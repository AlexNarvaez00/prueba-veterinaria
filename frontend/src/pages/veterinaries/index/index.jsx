import { VeterinariesContainer } from "../../../contexts/VeterinariesContext";
import Table from "./Table";

const Index = ({ children }) => {
  return (
    <VeterinariesContainer>
      <section className="container m-auto px-11 py-11">
        <h1 className="text-4xl my-5">List of Veterinaries</h1>
        <Table />
      </section>
    </VeterinariesContainer>
  );
};

export default Index;
