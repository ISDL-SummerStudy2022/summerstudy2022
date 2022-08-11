import { memo, useCallback, VFC } from "react";

import classes from "./TodoAdd.module.scss";

import { Item } from "../types/item";

import { TodoItem } from "./TodoItem";

import sortImage from "../../assets/img/sort.png";

type Props = {
  items: Array<Item>;
  setItems: React.Dispatch<React.SetStateAction<Item[]>>;
  itemsDone: Array<Item>;
  setItemsDone: React.Dispatch<React.SetStateAction<Item[]>>;
  enddate: Date;
  setEndDate: React.Dispatch<React.SetStateAction<Date>>;
};

export const TodoAdd: VFC<Props> = memo((props) => {
  const { items, setItems, itemsDone, setItemsDone, enddate, setEndDate } = props;

  const onCheckChange = useCallback(
    (checkedItem: Item) => {
      // mapは配列の中の要素を１つずつ取り出し、処理後に新しい配列を作る
      const newItems = items.map((item) => {
        // checkされたinputにあるkeyと、stateにあるitemのkeyが一致するなら、doneのfalseをtrueにして、変更したitemをsetItemsに指定する
        if (item.key === checkedItem.key) {
          item.done = !item.done;
        }
        return item;
      });
      setItems(newItems);
    },
    [items, setItems]
  );

  const TodoDoneLength = useCallback(() => {
    const newItemsDone = items.filter((item) => item.done === false);
    if (newItemsDone.length) return <span className={classes.todoLength_alert}>{`${newItemsDone.length}個のタスクが残っています`}</span>;
    return "タスクはありません";
  }, [items]);

  const onClickDelete = () => {
    if (!items.length) return;
    const newItems = items.filter((item) => item.done === false);
    setItems(newItems);
    const newItemsDone = items.filter((item) => item.done === true);
    setItemsDone([...itemsDone, ...newItemsDone]);
  };

  // const onClickAllClear = () => {
  //   const newItems: Array<Item> = [];
  //   setItems(newItems);
  // };
  const onClickClear = () => {
    if (!items.length) return;
    const newItems = items.filter((item) => item.done === false);
    setItems(newItems);
  };

  // sort機能
  const sortItems = () => {
    const copyItems = items.slice();
    const sortItems_up = [...items].sort((a, b) => 0 - (a.priority > b.priority ? 1 : -1));
    const sortItems_down = [...sortItems_up].sort((a, b) => 0 - (a.priority < b.priority ? 1 : -1));
    if (copyItems[0].priority === sortItems_up[0].priority) {
      setItems(sortItems_down);
    } else {
      setItems(sortItems_up);
    }
  };

  const sortDateItems = () => {
    const copyItems = items.slice();
    const sortItems_up = [...items].sort((a, b) => 0 - (a.date > b.date ? 1 : -1));
    const sortItems_down = [...sortItems_up].sort((a, b) => 0 - (a.date < b.date ? 1 : -1));
    if (copyItems[0].date === sortItems_up[0].date) {
      setItems(sortItems_down);
      console.log("down");
    } else {
      setItems(sortItems_up);
      console.log("up");
    }
  };

  return (
    <div className={classes.block}>
      <div className={classes.blockUpper}>
        <div className={classes.blockUpperHead}>
          <div className={classes.todoSort}>
            <button className={classes.sortDate} onClick={sortDateItems} type="button">
              <img src={sortImage} alt="" />
            </button>
            <button className={classes.sort} onClick={sortItems} type="button">
              <img src={sortImage} alt="" />
            </button>
          </div>
          <div className={classes.todoLength}>{TodoDoneLength()}</div>
        </div>
        {items.map((item) => (
          <TodoItem key={item.key} item={item} onCheck={onCheckChange} enddate={enddate} setEndDate={setEndDate} />
        ))}
      </div>
      <div className={classes.blockBotton}>
        <button className={classes.button} onClick={onClickDelete} type="button">
          完了済を削除
        </button>
        <button className={`${classes.button} ${classes.button_clear}`} onClick={onClickClear} type="button">
          やることをクリア
        </button>
      </div>
    </div>
  );
});
