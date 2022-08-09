import { ChangeEvent, KeyboardEvent, memo, useCallback, VFC } from 'react';
import * as React from "react";
import { fakeAuthProvider } from "../modules/auth";
import {
  Routes,
  Route,
  Link,
  useNavigate,
  useLocation,
  Navigate,
  Outlet,
} from "react-router-dom";
import classes from './Menubar.module.scss';

export const Menubar: VFC = memo(() => {

  return (
    <nav className={classes.block}>
        <ul className={classes.ul} >
        <li className={classes.li}><a className={classes.sitetitle} href="/">ISDL Todo</a></li>
        <li className={classes.li}><a className={classes.lia} href="/">Home</a></li>
        <li className={classes.li}><a className={classes.lia} href="/login">Login</a></li>
        <li className={classes.li}><a className={classes.lia} href="/auth">Auth</a></li>
        </ul>
    </nav>
  );
});

