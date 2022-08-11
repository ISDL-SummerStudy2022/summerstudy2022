import { ChangeEvent, KeyboardEvent, memo, useCallback, VFC } from 'react';

import classes from './LoginInput.module.scss';

type Props = {
  // username: string;
  Username: string;
  setUsername: React.Dispatch<React.SetStateAction<string>>;
  typing: boolean;
  // setTyping: React.Dispatch<React.SetStateAction<boolean>>;
};

export const LoginInput: VFC<Props> = memo((props) => {
  const {Username, setUsername, typing} = props;

  const handleChange = useCallback((e: ChangeEvent<HTMLInputElement>) => setUsername(e.target.value), [setUsername]);
  
  // const handleKeyDown = (e: KeyboardEvent<HTMLInputElement>) => {
  //   if (!password) return;
  //   setText(password)
  // };
  
  return (
    <div className={classes.block}>
      <div>
        <input
        className={classes.input}
        type="text"
        placeholder="Username"
        value={Username}
        onChange={handleChange}

        // onKeyDown={handleKeyDown}
        // onCompositionStart={() => setTyping(true)}
        // onCompositionEnd={() => setTyping(false)}
        />
      </div>
    </div>
  );
});