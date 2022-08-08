import { ChangeEvent, KeyboardEvent, memo, useCallback, VFC } from 'react';

import classes from './LoginInput.module.scss';

type Props = {
  // username: string;
  password: string;
  setPassword: React.Dispatch<React.SetStateAction<string>>;
  typing: boolean;
  setTyping: React.Dispatch<React.SetStateAction<boolean>>;
};

export const PasswordInput: VFC<Props> = memo((props) => {
  const {password, setPassword, typing, setTyping} = props;

  const handleChange = useCallback((e: ChangeEvent<HTMLInputElement>) => setPassword(e.target.value), [setPassword]);
  
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
        placeholder="Password"
        value={password}
        onChange={handleChange}

        // onKeyDown={handleKeyDown}
        // onCompositionStart={() => setTyping(true)}
        // onCompositionEnd={() => setTyping(false)}
        />
      </div>
    </div>
  );
});