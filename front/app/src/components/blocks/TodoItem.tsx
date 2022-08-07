import { memo, useMemo, VFC } from 'react';

import classes from './TodoItem.module.scss';

import { Item } from '../types/item';

type Props = {
  item: Item;
  onCheck: (checkedItem: Item) => void;
};

export const TodoItem: VFC<Props> = memo((props) => {
  const { item, onCheck } = props;
  const handleChange = () => onCheck(item);

  const priority_text = () => {
    if (item.priority === 1) return "!!!"
    else if (item.priority === 2) return "!!"
    else if (item.priority === 3) return "!"
  }

  return (
    <>
      {/* eslint-disable jsx-a11y/label-has-associated-control */}
      <div className={classes.block}>
        {/* <label className={classes.block}> */}
          <div className={classes.form1}>
            <span className={classes.priority}>{priority_text()}</span>
            <span className={item.done ? `${classes.text_done} ${classes.text}` : `${classes.text}`}>{item.text}</span>
          </div>
          <div className={classes.form2}>
            <p className={classes.genre}># {item.genre}</p>
          </div>
          <input type="checkbox" checked={item.done} onChange={handleChange} />
        {/* </label> */}
      </div>
      {/* eslint-disable jsx-a11y/label-has-associated-control */}
    </>
  );
});
