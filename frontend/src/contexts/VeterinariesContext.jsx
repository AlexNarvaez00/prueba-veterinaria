import { createContext, useEffect, useState } from "react";
import { getAllVeterinaries } from "../services/veterinaryService";

export const VeterinariesContext = createContext(null);

export const VeterinariesContainer = ({ children }) => {
  const [currentPage, setCurrentPage] = useState(1);
  const [totalPages, setTotalPages] = useState(0);
  const [veterinaries, setVeterinaries] = useState({});
  const [isLoading, setIsLoading] = useState({});
  
  useEffect(() => {
    setIsLoading(true)
    getAllVeterinaries(currentPage).then((res) => {
      const { data } = res;
      setVeterinaries(data);
      setTotalPages(data.totalPages);
      setIsLoading(false);
    });
  }, [currentPage]);

  return (
    <VeterinariesContext.Provider value={{ veterinaries, currentPage, setCurrentPage, totalPages, isLoading}}>
      {children}
    </VeterinariesContext.Provider>
  );
};
