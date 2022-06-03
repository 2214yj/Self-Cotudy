import os
import sys
from sqlalchemy import Column, ForeignKey, Integer, String
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import relationship
from sqlalchemy import create_engine

Base = declarative_base()


class BookStore(Base):
    __tablename__ = 'bookstore'

    id = Column(Integer, primary_key=True)
    name = Column(String(100), nullable=False)

    @property
    def serialize(self):
        """Return object data in easily serializeable format"""
        return {
            'name': self.name,
            'id': self.id,
        }


class BookItem(Base):
    __tablename__ = 'bookitem'

    name = Column(String(100), nullable=False)
    id = Column(Integer, primary_key=True)
    price = Column(String(8))
    bookstore_id = Column(Integer, ForeignKey('bookstore.id'))
    bookstore = relationship(BookStore)

    @property
    def serialize(self):
        """Return object data in easily serializeable format"""
        return {
            'name': self.name,
            'id': self.id,
            'price': self.price,
        }


engine = create_engine('mysql+pymysql://root:Ga3785yj)!!#@localhost/bookstore')


Base.metadata.create_all(engine)
