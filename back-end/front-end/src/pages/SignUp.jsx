import { Link } from "react-router-dom";
import "../css/SignUp.css";
import { IoMdAdd } from "react-icons/io";
import { useState } from "react";
import axios from "axios";

const apiUrl = "http://localhost:8080/v1/client";

function SignUp() {
  const [cellphones, setCellphones] = useState([]);
  const [errorMessage, setErrorMessage] = useState("");
  const [displayErrorMsg, setDisplayErrorMsg] = useState(false);
  const [nome, setNome] = useState("");
  const [endereco, setEndereco] = useState("");
  const [bairro, setBairro] = useState("");
  const [celular, setCelular] = useState("");
  const [cellphoneArr, setCellphoneArr] = useState([]);

  const handleSubmit = e => {
    e.preventDefault();

    const formData = new FormData(e.target);
    const formJson = Object.fromEntries(formData.entries());

    axios
      .post(apiUrl, {
        name: `${formJson.nome}`,
        address: {
          address: `${formJson.endereco}`,
          neighborhood: `${formJson.bairro}`,
        },
        cellphones: [...cellphoneArr, celular],
      })
      .then(response => {
        setDisplayErrorMsg(false);

        setNome("");
        setEndereco("");
        setBairro("");
        setCelular("");
        console.log(response.data);
        console.log();
      })
      .catch(err => {
        setDisplayErrorMsg(true);
        setErrorMessage(err.response.data.error);
        console.log(cellphoneArr);
      });
  };

  const duplicateCellphone = () => {
    setCellphoneArr([...cellphoneArr, celular]);
    setCelular("");
  };

  return (
    <div className="SignUpContainer">
      <div className="SignUpClient">
        <h1>Cadastro</h1>
        <form className="ClientForm" onSubmit={handleSubmit} id="ClientForm">
          <input
            type="text"
            name="nome"
            onChange={e => setNome(e.target.value)}
            value={nome}
            className="Name"
            placeholder="Nome"
          />
          <input
            type="text"
            name="endereco"
            onChange={e => setEndereco(e.target.value)}
            value={endereco}
            className="Address"
            placeholder="Endereço"
          />
          <input
            type="text"
            name="bairro"
            onChange={e => setBairro(e.target.value)}
            value={bairro}
            className="District"
            placeholder="Bairro"
          />
          <div className="Cellphone">
            <input
              type="tel"
              name="celular"
              maxLength="12"
              onChange={e => setCelular(e.target.value)}
              value={celular}
              placeholder="Celular"
            />
            <IoMdAdd
              className="ClientListBtn"
              onClick={() => duplicateCellphone(celular)}
            />
            {cellphones}
          </div>
        </form>
        <button className="SubmitBtn" form="ClientForm" type="submit">
          Registrar-se
        </button>
        <p className={displayErrorMsg ? "ErrorMessage" : "HideErrorMessage"}>
          {errorMessage}
        </p>
        <Link to="/">
          <span className="CloseBtn"></span>
        </Link>
      </div>
    </div>
  );
}

export default SignUp;
