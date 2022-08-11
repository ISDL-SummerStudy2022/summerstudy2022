import { ChangeEvent, memo, useCallback, VFC } from 'react';

import classes from './LoginInput.module.scss';

type Props = {
    Email: string;
    // password: string;
    setEmail: React.Dispatch<React.SetStateAction<string>>;
    typing: boolean;
    // setTyping: React.Dispatch<React.SetStateAction<boolean>>;
    // onAdd: (text: string) => void;
};

export const EmailInput: VFC<Props> = memo((props) =>{
    const { Email, setEmail, typing} = props;

    const handleChange = useCallback((e: ChangeEvent<HTMLInputElement>) => setEmail(e.target.value), [setEmail]);

    return (
        <div className={classes.block}>
            <div>
                <input
                className={classes.input}
                type="text"
                placeholder="Eamil"
                value={Email}
                onChange={handleChange}
                />
            </div>
        </div>
    )
});