import React, { useCallback, useState, useEffect } from 'react';
import classes from './Todo.module.scss';

import { RegistUserInput } from '../blocks/RegistUserInput';
import { PasswordInput } from '../blocks/PasswordInput';
import { EmailInput } from '../blocks/EmailInput';

export const RegistUser = () => {
  const [Username, setUsername] = useState<string>('');
  const [Password, setPassword] = useState<string>('');
  const [Email, setEmail] = useState<string>('');
  const [Posts, setPosts] = useState([]);
  // const [user, setUser] = useState<User>([{}]);

  const [typing, setTyping] = useState<boolean>(false);

  const onClickRegist = 
    (event: React.MouseEvent<HTMLButtonElement, MouseEvent>) => {
      // 入力データ確認
      console.log(Username);
      console.log(Email);
      console.log(Password);

      // apiのurl
      const posturl = "http://localhost:8080/register";
      // 送信データ作成
      const info = {
        username: Username, email: Email, password: Password
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
        setPosts(data);
        // 返り値確認（=>ユーザ登録はboolean）
        console.log(data);
      });
    };

  return (
    <div className={classes.container}>
      <div className={classes.inner}>
        <div className={classes.main}>
          <h1 className={classes.heading}>Register</h1>
          {/* 入力 */}
          <RegistUserInput Username={Username} setUsername={setUsername} typing={typing} />
          <EmailInput Email={Email} setEmail={setEmail} typing={typing} />
          <PasswordInput password={Password} setPassword={setPassword} typing={typing} setTyping={setTyping} />
          {/* 登録ボタン */}
          <div className={classes.blockBottom}><button className={classes.button} onClick={onClickRegist} type="button">Regist </button></div>
        </div>
      </div>
    </div>
  );
};