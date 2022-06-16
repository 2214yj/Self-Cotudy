from flask import Flask, render_template, request, redirect, url_for, jsonify
from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
from database_setup_book import Base, BookStore, BookItem

app = Flask(__name__)

engine = create_engine('mysql+pymysql://root:Ga3785yj)!!#@localhost/bookstore')
Base.metadata.bind = engine

DBSession = sessionmaker(bind=engine)
session = DBSession()

# 1. JSON return 함수 구현 할 것
@app.route('/bookstores/<int:bookstore_id>/booklist/JSON')
def bookListJSON(bookstore_id):
    bookstore = session.query(BookStore).filter_by(id=bookstore_id).one()
    books = session.query(BookItem).filter_by(
        bookstore_id=bookstore_id).all()
    return jsonify(BookItems=[i.serialize for i in books])


# 2. bookList 함수 구현 할 것 (booklist.html templates 구축해야 함)
@app.route('/')
@app.route('/bookstores/<int:bookstore_id>/booklist')
def bookList(bookstore_id=None):
    if bookstore_id == None:
        bookstore_id = 1
    bookstore = session.query(BookStore).filter_by(id=bookstore_id).one()
    books = session.query(BookItem).filter_by(bookstore_id=bookstore_id)
    return render_template(
        'booklist.html', bookstore=bookstore, books=books, bookstore_id=bookstore_id)


# 3. newBookItem 함수 구현 할 것 (newbook.html templates 구축해야 함)
@app.route('/bookstores/<int:bookstore_id>/new', methods=['GET', 'POST'])
def newBookItem(bookstore_id):
    if request.method == 'POST':
        newBook = BookItem(name=request.form['name'], price=request.form['price'], bookstore_id=bookstore_id )
        session.add(newBook)
        session.commit()
        return redirect(url_for('bookList', bookstore_id=bookstore_id))
    else:
        return render_template('newbook.html',bookstore_id=bookstore_id)


# 4. editBookItem 함수 구현 할 것 (editbook.html templates 구축해야 함)
@app.route('/bookstores/<int:bookstore_id>/<int:book_id>/edit',
           methods=['GET', 'POST'])
def editBookItem(bookstore_id, book_id):
    editedBook = session.query(BookItem).filter_by(id=book_id).one()
    if request.method == 'POST':
        if request.form['name']:
            editedBook.name = request.form['name']
        if request.form['price']:
            editedBook.price = request.form['price']
        session.add(editedBook)
        session.commit()
        return redirect(url_for('bookList', bookstore_id=bookstore_id))
    else:
        return render_template(
            'editbook.html', bookstore_id=bookstore_id, book_id=book_id, book=editedBook)


# 5. deleteBookItem 함수 구현 할 것 (deletebook.html templates 구축해야 함)
@app.route('/bookstores/<int:bookstore_id>/<int:book_id>/delete',
           methods=['GET', 'POST'])
def deleteBookItem(bookstore_id, book_id):
    bookToDelete = session.query(BookItem).filter_by(id=book_id).one()
    if request.method == 'POST':
        session.delete(bookToDelete)
        session.commit()
        return redirect(url_for('bookList', bookstore_id=bookstore_id))
    else:
        return render_template('deletebook.html', book=bookToDelete)


if __name__ == '__main__':
    app.debug = True
    app.run(host='127.0.0.1', port=5000)
