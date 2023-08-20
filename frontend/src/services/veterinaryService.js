import axios from "axios";
import { BASE_URL } from "./constans";

export function getAllVeterinaries(page) {
  page--;
  return axios.get(BASE_URL + `veterinaries`, {
    params: {
      page: page,
    },
  });
}

export function getVeterinary(id) {
  return axios.get(BASE_URL + `veterinaries/` + id);
}

export function createNewVeterinary(data) {
  return axios.post(BASE_URL + `veterinaries/create`, data, {
    headers: {
      "Content-Type": "application/json",
    },
  });
}

export function updateVeterinary(id, data) {
  return axios.put(BASE_URL + `veterinaries/${id}`, data, {
    headers: {
      "Content-Type": "application/json",
    },
  });
}

export function deleteVeterinary(id) {
  return axios.delete(BASE_URL + `veterinaries/` + id);
}
