import { ChangeEvent, KeyboardEvent, memo, useCallback, VFC, useState, forwardRef, useRef } from "react";

import classes from "./TodoInput.module.scss";

import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

type Props = {
  text: string;
  setText: React.Dispatch<React.SetStateAction<string>>;
  typing: boolean;
  setTyping: React.Dispatch<React.SetStateAction<boolean>>;
  onAdd: (text: string, genre: string, priority: number, enddate: Date) => void;
  genre: string;
  setGenre: React.Dispatch<React.SetStateAction<string>>;
  priority: number;
  setPriority: React.Dispatch<React.SetStateAction<number>>;
  enddate: Date;
  setEndDate: React.Dispatch<React.SetStateAction<Date>>;
};

const genreLists = [
  { id: "none", name: "ジャンル" },
  { id: "研究室", name: "研究室" },
  { id: "プライベート", name: "プライベート" },
  { id: "その他", name: "その他" },
];

const priorityLists = [
  { id: 0, name: "優先度" },
  { id: 1, name: "大" },
  { id: 2, name: "中" },
  { id: 3, name: "小" },
];

export const TodoInput: VFC<Props> = memo((props) => {
  const { text, setText, typing, setTyping, onAdd, genre, setGenre, priority, setPriority, enddate, setEndDate } = props;

  const handleChange = useCallback((e: ChangeEvent<HTMLInputElement>) => setText(e.target.value), [setText]);

  const handleChange_1 = useCallback((e: ChangeEvent<HTMLSelectElement>) => setGenre(e.target.value), [setGenre]);

  const handleChange_2 = useCallback((e: ChangeEvent<HTMLSelectElement>) => setPriority(Number(e.target.value)), [setPriority]);

  // const handleKeyDown = (e: KeyboardEvent<HTMLInputElement>) => {
  //   if (!text) return;
  //   if (e.key !== 'Enter' || typing) return;
  //   onAdd(text);
  //   setText('');
  // };

  const onClickAdd = () => {
    if (!text) {
      alert("テキストを入力してください");
      return;
    }
    if (!genre || genre === 'none') {
      alert("ジャンルを選択してください");
      return;
    }
    if (!priority || priority === 0) {
      alert("優先度を選択してください");
      return;
    }
    onAdd(text, genre, priority, enddate);
    setText("");
    // setEndDate(null)
  };

  return (
    <div>
      {/* <div className={classes.inputlabel}>
        <span className={classes.datelabel}>期限</span>
        <span className={classes.textlabel}>入力欄</span>
        <span className={classes.genrelabel}>ジャンル</span>
        <span className={classes.prioritylabel}>優先度</span>
      </div> */}
      <div className={classes.block}>
        <div className={classes.dateblock}>
          <DatePicker className={classes.date} selected={enddate} dateFormat="MM/dd" onChange={(e: Date) => setEndDate(e)} disabledKeyboardNavigation />
        </div>
        <input
          className={classes.input}
          type="text"
          placeholder="やることを入力"
          value={text}
          onChange={handleChange}
          // onKeyDown={handleKeyDown}
          onCompositionStart={() => setTyping(true)}
          onCompositionEnd={() => setTyping(false)}
        />
        <select className={classes.genre} onChange={handleChange_1}>
          {genreLists.map((genreList) => (
            <option value={genreList.id}>{genreList.name}</option>
          ))}
        </select>
        <select className={classes.priority} onChange={handleChange_2}>
          {priorityLists.map((priorityList) => (
            <option value={priorityList.id}>{priorityList.name}</option>
          ))}
        </select>
      </div>
      <div className={classes.blockBottom}>
        <button className={classes.button} onClick={onClickAdd} type="button">
          やることリストに追加
        </button>
      </div>
    </div>
  );
});
