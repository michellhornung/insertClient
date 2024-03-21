import "./App.css";
import ClientList from "./pages/ClientList";
import { Route, Routes } from "react-router-dom";
import SignUp from "./pages/SignUp";
import Edit from "./pages/Edit";

function App() {
  return (
    <Routes>
      <Route path="/" element={<ClientList />} />
      <Route path="/sign-up" element={<SignUp />} />
      <Route path="/edit/:id" element={<Edit />} />
    </Routes>
  );
}

export default App;
