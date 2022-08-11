import { useCallback, useMemo, useState } from "react";
import classes from "./Todo.module.scss";

import { Item } from "../types/item";


import { TodoInput } from "../blocks/TodoInput"; //コンポーネント読み込み
import { TodoAdd } from "../blocks/TodoAdd"; //コンポーネント読み込み
import { TodoDones } from "../blocks/TodoDones"; //コンポーネントの読み込み

const getKey = () => Math.random().toString(32).substring(2); // 0〜1未満の乱数字を取得して、数字を32進法に文字列に変換。前から３番目から文字を抽出

// interface UserName {
//   [id: number]: string;
// }

export const Todo = () => {
  // userの辞書
  const name = "yamakawa";
  // const userName: UserName = {};
  // userName[1] = name;
  //
  // const [items, setItems] = useState<Array<Item>>([{
  //   key: getKey(), user: name, text: 'これはダミーのTODOです', done: false, genre: 'その他', priority: 0
  // }]);
  const [items, setItems] = useState<Array<Item>>([]);
  const [itemsDone, setItemsDone] = useState<Array<Item>>([]);
  const [text, setText] = useState<string>("");
  const [typing, setTyping] = useState<boolean>(false);
  //追加
  const [genre, setGenre] = useState<string>("");
  const [priority, setPriority] = useState<number>(0);
  const [enddate, setEndDate] = useState<Date>(new Date());

  const onAdd = useCallback(
    (inputText: string, inputGenre: string, inputPriority: number, inputDate: Date) => {
      setItems([...items, { key: getKey(), user: name, text: inputText, done: false, genre: inputGenre, priority: inputPriority, date: inputDate }]);
      console.log(items);
    },
    [items]
  );

  return (
    <div className={classes.container}>
      <div className={classes.inner}>
        <div className={classes.main}>
          <h1 className={classes.heading}>{name}のやることリスト</h1>
          <TodoInput onAdd={onAdd} text={text} setText={setText} typing={typing} setTyping={setTyping} genre={genre} setGenre={setGenre} priority={priority} setPriority={setPriority} enddate={enddate} setEndDate={setEndDate} />
          <TodoAdd items={items} setItems={setItems} itemsDone={itemsDone} setItemsDone={setItemsDone} enddate={enddate} setEndDate={setEndDate} />
        </div>
        <TodoDones itemsDone={itemsDone} />
      </div>
    </div>
  );
};
