import { ChangeEvent, KeyboardEvent, memo, useCallback, VFC } from 'react';

import classes from './LoginInput.module.scss';

type Props = {
  // username: string;
  password: string;
  setText: React.Dispatch<React.SetStateAction<string>>;
  typing: boolean;
  setTyping: React.Dispatch<React.SetStateAction<boolean>>;
  onAdd: (text: string) => void;
};

export const PasswordInput: VFC<Props> = memo((props) => {
  const {password, setText, typing, setTyping, onAdd } = props;

  const handleChange = useCallback((e: ChangeEvent<HTMLInputElement>) => setText(e.target.value), [setText]);
  
  const handleKeyDown = (e: KeyboardEvent<HTMLInputElement>) => {
    if (!password) return;
    if (e.key !== 'Enter' || typing) return;
    onAdd(password);
    setText('');
  };
  
  return (
    <div className={classes.block}>
      <div>
        <input
        className={classes.input}
        type="text"
        placeholder="Password"
        value={password}
        onChange={handleChange}

        onKeyDown={handleKeyDown}
        onCompositionStart={() => setTyping(true)}
        onCompositionEnd={() => setTyping(false)}
        />
      </div>
    </div>
  );
});