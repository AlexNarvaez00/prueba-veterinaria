import { Spinner, Table } from "flowbite-react";
import { Pagination } from "flowbite-react";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { getAllVeterinaries } from "../../../services/veterinaryService";

const TableContainer = () => {

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


  if (isLoading) {
    return (
      <section className="flex">
        <div className="mx-auto">
          <Spinner size="xl" />
        </div>
      </section>
    );
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
            {veterinaries?.content.map((veterinary) => {
              return (
                <Table.Row key={veterinary.id}>
                  <Table.Cell className="whitespace-nowrap trucate font-medium text-gray-900 dark:text-white">
                    <Link to={veterinary.id}>{veterinary.id}</Link>
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
      <section className="flex justify-between items-end mt-5">
        <Pagination
          className=""
          showIcons
          currentPage={currentPage}
          onPageChange={(page) => {
            setCurrentPage(page);
          }}
          totalPages={totalPages}
        />
        <p>
          Total <strong>{veterinaries.content.length}</strong> elements
        </p>
      </section>
    </section>
  );
};

export default TableContainer;
