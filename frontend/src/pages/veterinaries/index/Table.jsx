import { useContext } from "react";
import { VeterinariesContext } from "../../../contexts/VeterinariesContext";
import { Table } from "flowbite-react";
import { Pagination } from "flowbite-react";

const TableContainer = () => {
  const { content } = useContext(VeterinariesContext).veterinaries;
  const { currentPage,setCurrentPage,totalPages } = useContext(VeterinariesContext);

  if (!content) {
    return <h1>Errors</h1>;
  }

  return (
    <section>
      <figure>
        <Table hoverable>
          <Table.Head>
            <Table.HeadCell>#</Table.HeadCell>
            <Table.HeadCell>Name</Table.HeadCell>
            <Table.HeadCell>First name</Table.HeadCell>
            <Table.HeadCell>Last name</Table.HeadCell>
          </Table.Head>
          <Table.Body className="divide-y">
            {content.map((veterinary) => {
              return (
                <Table.Row key={veterinary.id}>
                  <Table.Cell className="whitespace-nowrap trucate font-medium text-gray-900 dark:text-white">
                    {veterinary.id}
                  </Table.Cell>
                  <Table.Cell>{veterinary.name}</Table.Cell>
                  <Table.Cell>{veterinary.first_name}</Table.Cell>
                  <Table.Cell>{veterinary.last_name}</Table.Cell>
                </Table.Row>
              );
            })}
          </Table.Body>
        </Table>
      </figure>
      <Pagination
        className="mt-5"
        currentPage={currentPage}
        onPageChange={(page) => {
          setCurrentPage(page);
        }}
        totalPages={totalPages}
      />
    </section>
  );
};

export default TableContainer;
