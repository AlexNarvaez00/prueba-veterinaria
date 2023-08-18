import axios from "axios";
import { BASE_URL } from "./constans";

export function getAllOwners() {
  return axios.get(BASE_URL + `owners`);
}

export function createNewOwner(data) {
  return axios.post(BASE_URL + `owners`, data);
}

export function deleteOwner(id) {
  return axios.delete(BASE_URL + `owners/` + id);
}
