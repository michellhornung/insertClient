import "../css/ClientList.css";
import { IoMdAdd } from "react-icons/io";
import { FaRegTrashAlt } from "react-icons/fa";
import { Link } from "react-router-dom";
import { useEffect, useState } from "react";
import axios from "axios";

const apiUrl = "http://localhost:8080/v1/client";

function ClientList() {
  const [clients, setClients] = useState();

  useEffect(() => {
    axios.get(apiUrl).then(response => {
      setClients(response.data);
    });
  }, []);

  const handleDelete = e => {
    axios.delete(`${apiUrl}/${e}`);
    setClients(clients.filter(item => item.id !== e));
  };

  return (
    <div className="ClientList">
      <div className="registredClients">
        <h1>Clientes cadastrados</h1>
        <table className="clientsInfo">
          <thead>
            <tr>
              <th className="editClient">Editar</th>
              <th>ID</th>
              <th>Nome</th>
              <th>Endereço</th>
              <th>Bairro</th>
              <th className="addClient">
                <p>Celular</p>
                <Link to="/sign-up">
                  <IoMdAdd className="addClientBtn" />
                </Link>
              </th>
            </tr>
          </thead>
          <tbody>
            {clients &&
              clients.map(el => (
                <tr key={el.id}>
                  <td>
                    <Link to={`/edit/${el.id}`}>
                      <input name="EditClientCheckbox" type="checkbox" />
                    </Link>
                  </td>
                  <td>{el.id}</td>
                  <td>{el.name}</td>
                  <td>{el.address.address}</td>
                  <td>{el.address.neighborhood}</td>
                  <td className="deleteClient">
                    <p>
                      {el.cellphones.length > 1
                        ? `${el.cellphones[0]}...`
                        : el.cellphones[0]}
                    </p>
                    <FaRegTrashAlt
                      className="deleteClientBtn"
                      onClick={() => handleDelete(el.id)}
                    />
                  </td>
                </tr>
              ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default ClientList;
