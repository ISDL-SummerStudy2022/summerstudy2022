import { ChangeEvent, KeyboardEvent, memo, useCallback, VFC, useState } from 'react';

import classes from './TodoInput.module.scss';

type Props = {
  text: string;
  setText: React.Dispatch<React.SetStateAction<string>>;
  typing: boolean;
  setTyping: React.Dispatch<React.SetStateAction<boolean>>;
  onAdd: (text: string, genre: string) => void;
  genre: string;
  setGenre: React.Dispatch<React.SetStateAction<string>>;
};

const genreLists = [
  { id: "a", name: "研究室"},
  { id: "b", name: "プライベート"},
]

export const TodoInput: VFC<Props> = memo((props) => {
  const { text, setText, typing, setTyping, onAdd, genre, setGenre } = props;
  const handleChange = useCallback((e: ChangeEvent<HTMLInputElement>) => setText(e.target.value), [setText]);

  const handleChange_1 = useCallback((e: ChangeEvent<HTMLSelectElement>) => setGenre(e.target.value), [setGenre]);

  // const handleKeyDown = (e: KeyboardEvent<HTMLInputElement>) => {
  //   if (!text) return;
  //   if (e.key !== 'Enter' || typing) return;
  //   onAdd(text);
  //   setText('');
  // };

  const onClickAdd = () => {
    if (!text) return;
    onAdd(text, genre);
    console.log(genre)
    setText('');
  }

  return (
    <div>
      <div className={classes.block}>
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
      <select
        className={classes.genre}
        onChange={handleChange_1}
        >{
        genreLists.map(genreList => (
          <option value={genreList.id}>{genreList.name}</option>
        ))
      }
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
