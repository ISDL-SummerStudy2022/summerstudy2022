import { ChangeEvent, KeyboardEvent, memo, useCallback, VFC } from 'react';

import classes from './LoginInput.module.scss';

type Props = {
  username: string;
  // password: string;
  setUsername: React.Dispatch<React.SetStateAction<string>>;
  typing: boolean;
  // setTyping: React.Dispatch<React.SetStateAction<boolean>>;
  // onAdd: (text: string) => void;
};

export const LoginInput: VFC<Props> = memo((props) => {
  const { username, setUsername, typing} = props;

  const handleChange = useCallback((e: ChangeEvent<HTMLInputElement>) => setUsername(e.target.value), [setUsername]);
  
  // const handleKeyDown = (e: KeyboardEvent<HTMLInputElement>) => {
  //   if (!username) return;
  //   if (e.key !== 'Enter' || typing) return;
  //   onAdd(username);
  //   setText('');
  // };
  
  return (
    <div className={classes.block}>
      <div>
        <input
        className={classes.input}
        type="text"

        placeholder="Email"
        value={username}
        onChange={handleChange}

        // onKeyDown={handleKeyDown}
        // onCompositionStart={() => setTyping(true)}
        // onCompositionEnd={() => setTyping(false)}
        />
      </div>
      
    </div>
  );
});