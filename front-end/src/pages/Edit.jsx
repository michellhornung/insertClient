import { Link, useParams } from "react-router-dom";
import "../css/Edit.css";
import { IoMdAdd } from "react-icons/io";
import { useState } from "react";
import axios from "axios";

const apiUrl = "http://localhost:8080/v1/client";

function Edit() {
  const [cellphones, setCellphones] = useState([]);
  const { id } = useParams();
  const [errorMessage, setErrorMessage] = useState("");
  const [displayErrorMsg, setDisplayErrorMsg] = useState(false);
  const [nome, setNome] = useState("");
  const [endereco, setEndereco] = useState("");
  const [bairro, setBairro] = useState("");
  const [celular, setCelular] = useState("");
  const [cellphoneArr, setCellphoneArr] = useState([]);

  const handleEdit = e => {
    e.preventDefault();

    const formData = new FormData(e.target);
    const formJson = Object.fromEntries(formData.entries());

    axios
      .put(apiUrl, {
        id: id,
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
      })
      .catch(err => {
        setDisplayErrorMsg(true);
        setErrorMessage(err.response.data.error);
      });
  };

  const duplicateCellphone = () => {
    setCellphoneArr([...cellphoneArr, celular]);
    setCelular("");
  };

  return (
    <div className="EditContainer">
      <div className="EditClient">
        <h1>Editar Cadastro</h1>
        <form className="ClientForm" onSubmit={handleEdit} id="ClientForm">
          <input
            type="text"
            name="nome"
            className="Name"
            onChange={e => setNome(e.target.value)}
            value={nome}
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
              placeholder="Celular"
              onChange={e => setCelular(e.target.value)}
              value={celular}
            />
            <IoMdAdd className="ClientListBtn" onClick={duplicateCellphone} />
            {cellphones}
          </div>
        </form>
        <button className="SubmitBtn" form="ClientForm" type="submit">
          Editar
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

export default Edit;
