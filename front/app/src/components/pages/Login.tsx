import {  useState } from 'react';
import classes from './Login.module.scss';
import { useNavigate } from "react-router-dom";
import { LoginInput } from '../blocks/LoginInput'; //コンポーネント読み込み
import { PasswordInput } from '../blocks/PasswordInput'
import { useAuth } from '../../App';


const getKey = () => Math.random().toString(32).substring(2); // 0〜1未満の乱数字を取得して、数字を32進法に文字列に変換。前から３番目から文字を抽出

export const Login = () => {
  let navigate = useNavigate();
  let auth = useAuth();
  const from = "/";

  const [Username, setUsername] = useState<string>('');
  const [Userid, setUser] = useState<string>('');

  const [Password, setPassword] = useState<string>('');

  const [typing, setTyping] = useState<boolean>(false);

  
  const onClickLogin = () => {
    console.log(Username)
    console.log(Password)
    const posturl = "http://localhost:8080/user/select";
      // 送信データ作成
      const info = {
        username: Username, userid: Userid, password: Password
      };
      // Javaと通信開始（POSTでデータ送信）
      const response = fetch(posturl, {
        method : "POST",
        headers : {"Content-Type": "application/json"},
        mode : 'cors',
        body: JSON.stringify(info)
      })
      .then((res) => res.json())
      .then((data) => {
        // setPosts(data);
        // 返り値確認（=>ユーザ登録はboolean）
        console.log(data);
        if (data.check){
          auth.signin(Username, Userid, () => {
            navigate(from, { replace: true });
          });}
        else{
          auth.signout(() => navigate("/login"));
        }
      });
  };
  return (
    <div className={classes.container}>
      <div className={classes.inner}>
        <div className={classes.main}>
          <h1 className={classes.heading}>Login</h1>
          <LoginInput Username={Username} setUsername={setUsername} typing={typing} />
          <PasswordInput password={Password} setPassword={setPassword} typing={typing} setTyping={setTyping} />
          <div className={classes.blockBottom}><button className={classes.button} onClick={onClickLogin} type="button">Login </button></div>
        </div>
      </div>
    </div>
  );
};