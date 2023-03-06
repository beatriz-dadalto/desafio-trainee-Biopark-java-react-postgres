import { NavLink, Outlet } from 'react-router-dom';

export default function RootLayout() {
  return (
    <div className="root-layout">
      <header>
        <nav>
          <h1>Biopark Apartments</h1>
          <NavLink to="/">Home</NavLink>
          <NavLink to="login">Login | Cadastre-se</NavLink>
        </nav>
      </header>

      <main>
        <Outlet />
      </main>
    </div>
  );
}