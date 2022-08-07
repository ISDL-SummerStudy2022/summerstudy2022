import { useCallback, useState } from 'react';
import classes from './Todo.module.scss';

import { LoginInput } from '../blocks/LoginInput'; //コンポーネント読み込み
import { Item } from '../types/item';


const getKey = () => Math.random().toString(32).substring(2); // 0〜1未満の乱数字を取得して、数字を32進法に文字列に変換。前から３番目から文字を抽出

export const Login = () => {
  const [items, setItems] = useState<Array<Item>>([{ key: getKey(), text: 'これはダミーのTODOです', done: false }]);
  const [itemsDone, setItemsDone] = useState<Array<Item>>([]);
  const [text, setText] = useState<string>('');
  const [typing, setTyping] = useState<boolean>(false);
  const onAdd = useCallback(
    (inputText: string) => {
      setItems([...items, { key: getKey(), text: inputText, done: false }]);
    },
    [items]
  );
  return (
    <div className={classes.container}>
      <div className={classes.inner}>
        <div className={classes.main}>
          <h1 className={classes.heading}>Login</h1>
          <LoginInput onAdd={onAdd} username={text} password={text} setText={setText} typing={typing} setTyping={setTyping} />
        </div>
      </div>
    </div>
  );
};