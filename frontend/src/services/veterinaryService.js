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

export function createNewVeterinary(data) {
  return axios.post(BASE_URL + `veterinaries`, data);
}

export function deleteVeterinary(id) {
  return axios.delete(BASE_URL + `veterinaries/` + id);
}
