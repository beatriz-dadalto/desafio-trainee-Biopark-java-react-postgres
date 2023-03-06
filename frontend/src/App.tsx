import React from 'react';
import {
  createBrowserRouter,
  Route,
  createRoutesFromElements,
  RouterProvider,
} from 'react-router-dom';
import './App.css';
import RootLayout from './layouts/RootLayout';
import Home from './pages/Home';
import Login from './pages/Login';

const router = createBrowserRouter(
  createRoutesFromElements(
    <Route path="/" element={<RootLayout />}>
      <Route index element={<Home />} />
      <Route path="login" element={<Login />} />
    </Route>
  ),
);

function App() {
  return <RouterProvider router={router} />;
}

export default App;
