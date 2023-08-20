import { Button } from "flowbite-react";
import Layout from "./Layout";
import Table from "./partials//Table";
import { Link } from "react-router-dom";

const Index = () => {
  return (
    <Layout>
      <h1 className="text-4xl my-5">List of Veterinaries</h1>
      <div className="pb-4 flex justify-end">
        <Button as={Link} to="/veterinaries/create" gradientDuoTone="cyanToBlue">
          <p>Add</p>
        </Button>
      </div>
      <Table />
    </Layout>
  );
};

export default Index;
