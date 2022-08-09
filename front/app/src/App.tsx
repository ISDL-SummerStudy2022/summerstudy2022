import * as React from "react";
import {
  Routes,
  Route,
  // Link,
  useNavigate,
  useLocation,
  Navigate,
  Outlet,
} from "react-router-dom";
import { fakeAuthProvider } from "./components/modules/auth";
import { Todo } from './components/pages/Todo'; //Todo.tsxの読み込み
import { Login } from './components/pages/Login'; //Todo.tsxの読み込み
import {Menubar} from './components/blocks/Menubar'
import classes from './components/blocks/Menubar.module.scss'




export default function App() {
  return (
    <AuthProvider>
      <Routes>
        
        <Route element={<Layout />}>
          {/* <Route path="/" element={<PublicPage />} /> */}
          {/* <Route path="/auth" element={<LoginPage />} /> */}
          <Route path="/login" element={<Login />} />

          <Route
            path="/"
            element={
              <RequireAuth>
                <Todo />
              </RequireAuth>
            }
          />
        </Route>
      </Routes>
    </AuthProvider>
  );
}

function Layout() {
  return (
    <div>
      <Menubar />
      <Outlet />
    </div>
  );
}

interface AuthContextType {
  user: any;
  userid: any;
  signin: (user: string,userid: string, callback: VoidFunction) => void;
  signout: (callback: VoidFunction) => void;
}

let AuthContext = React.createContext<AuthContextType>(null!);

function AuthProvider({ children }: { children: React.ReactNode }) {
  let [user, setUser] = React.useState<any>(null);
  let [userid, setUserid] = React.useState<any>(null);


  let signin = (newUser: string, newUserid: string, callback: VoidFunction) => {
    return fakeAuthProvider.signin(() => {
      setUser(newUser);
      setUserid(newUserid);

      callback();
    });
  };

  let signout = (callback: VoidFunction) => {
    return fakeAuthProvider.signout(() => {
      setUser(null);
      setUserid(null);
      callback();
    });
  };

  let value = { user, userid, signin, signout };

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
}

function useAuth() {
  return React.useContext(AuthContext);
}

function AuthStatus() {
  let auth = useAuth();
  let navigate = useNavigate();

  if (!auth.user) {
    return <a className={classes.lia}>You are not logged in.</a>;
  }

  return (
    <a className={classes.lia}>
      Welcome {auth.user}!{" "}
      <button
        onClick={() => {
          auth.signout(() => navigate("/login"));
        }}
      >
        Sign out
      </button>
    </a>
  );
}

function RequireAuth({ children }: { children: JSX.Element }) {
  let auth = useAuth();
  let location = useLocation();

  if (!auth.user) {
    // Redirect them to the /login page, but save the current location they were
    // trying to go to when they were redirected. This allows us to send them
    // along to that page after they login, which is a nicer user experience
    // than dropping them off on the home page.
    return <Navigate to="/login" state={{ from: location }} replace />;
  }

  return children;
}

export {AuthStatus, useAuth};