import { ChangeEvent, KeyboardEvent, memo, useCallback, VFC } from 'react';

import classes from './LoginInput.module.scss';

type Props = {
    Username: string;
    // password: string;
    setUsername: React.Dispatch<React.SetStateAction<string>>;
    typing: boolean;
    // setTyping: React.Dispatch<React.SetStateAction<boolean>>;
    // onAdd: (text: string) => void;
};

export const RegistUserInput: VFC<Props> = memo((props) =>{
    const { Username, setUsername, typing} = props;

    const handleChange = useCallback((e: ChangeEvent<HTMLInputElement>) => setUsername(e.target.value), [setUsername]);

    return (
        <div className={classes.block}>
            <div>
                <input
                className={classes.input}
                type="text"
                placeholder="Username"
                value={Username}
                onChange={handleChange}
                />
            </div>
        </div>
    )
});