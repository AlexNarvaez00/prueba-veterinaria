import { createContext, useEffect, useState } from "react";
import { getAllVeterinaries } from "../services/veterinaryService";

export const VeterinariesContext = createContext(null);

export const VeterinariesContainer = ({ children }) => {
  const [currentPage, setCurrentPage] = useState(1);
  const [totalPages, setTotalPages] = useState(0);
  const [veterinaries, setVeterinaries] = useState({});
  
  useEffect(() => {
    getAllVeterinaries(currentPage).then((res) => {
      const { data } = res;
      setVeterinaries(data);
      setTotalPages(data.totalPages);
    });
  }, [currentPage]);

  return (
    <VeterinariesContext.Provider value={{ veterinaries, currentPage, setCurrentPage, totalPages}}>
      {children}
    </VeterinariesContext.Provider>
  );
};
