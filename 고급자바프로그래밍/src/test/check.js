import axios from "axios"

process.env.NODE_TLS_REJECT_UNAUTHORIZED = "0";

export async function checkWord(word) {
    //word = "바나나";
    console.log(word);

    let defaultURL = "https://opendict.korean.go.kr/api/search?";
    const key = "key=" + "3AEBFCE00275CF07019291B8639C7CF9";
    let part = "&part=word";
    let q = "&q=" + word;
    let sort = "&sort=dict";
    let fullURL = defaultURL + key + part + q + sort;

    let data = await axios.get(encodeURI(fullURL));

    let n = data.data.indexOf(word);
    if (n === -1) {
        return false;
    } else {
        let text = data.data.substring(n, n + word.length);
        console.log(text);
        return (text === word);
    }
}
