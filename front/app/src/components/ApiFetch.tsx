import React, {useState, useEffect} from "react";

export const ApiFetch = () => {
    const [Posts, setPosts] = useState([]);
    useEffect (() => {
        // fetch('')の文字列の部分に叩きたいREST APIのURLを記述
        const posturl = "http://localhost:8080/test/json2";
        // const params = {method : "POST",
        // headers : {"Content-Type": "application/json"},
        // mode : 'no-cors',
        // body: JSON.stringify({value1: "aaa",value2: "bbb"})
        // };
        // const params = {method : "POST"};
        // console.log(params);
        // fetch(url,{method : "GET", headers : {"Content-Type": "application/json"}})
        // mode : 'cors',
        // body: JSON.stringify({value1: "aaa",value2: "bbb"})})
        const test = {
            value1: "aaa", value2: "bbb"
        };
        const response = fetch(posturl,{method : "POST",
        headers : {"Content-Type": "application/json"},
        mode : 'cors',
        body: JSON.stringify(test)
        })
        // HTML形式で返ってくるため，json形式に変換
            .then((res) => res.json())
        // 変換したレスポンスをdataという変数に代入，それを引数にsetPostを用いて
            .then((data) => {
                setPosts(data);
                console.log(data);
            });
    }, []);

    return (
        <div>
            <ul>
                
            </ul>
        </div>
    )
}