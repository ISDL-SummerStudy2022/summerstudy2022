import { useCallback, useState } from 'react';
import classes from './Login.module.scss';

import { LoginInput } from '../blocks/LoginInput'; //コンポーネント読み込み
import {PasswordInput} from '../blocks/PasswordInput'
import { Item } from '../types/item';


const getKey = () => Math.random().toString(32).substring(2); // 0〜1未満の乱数字を取得して、数字を32進法に文字列に変換。前から３番目から文字を抽出

export const Login = () => {
  const [items, setItems] = useState<Array<Item>>([{ key: getKey(), text: 'これはダミーのTODOです', done: false }]);
  const [itemsDone, setItemsDone] = useState<Array<Item>>([]);
  const [Username, setUsername] = useState<string>('');
  const [Password, setPassword] = useState<string>('');

  const [typing, setTyping] = useState<boolean>(false);

  
  const onClickLogin = () => {
    console.log(Username)
    console.log(Password)
  };
  return (
    <div className={classes.container}>
      <div className={classes.inner}>
        <div className={classes.main}>
          <h1 className={classes.heading}>Login</h1>
          <LoginInput username={Username} setUsername={setUsername} typing={typing} />
          <PasswordInput password={Password} setPassword={setPassword} typing={typing} setTyping={setTyping} />
          <div className={classes.blockBottom}><button className={classes.button} onClick={onClickLogin} type="button">Login </button></div>
        </div>
      </div>
    </div>
  );
};