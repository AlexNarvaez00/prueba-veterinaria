import { useEffect, useState } from "react";
import Layout from "./Layout";
import { getVeterinary } from "../../services/veterinaryService";
import { useParams } from "react-router-dom";
import { Spinner } from "flowbite-react";

const Show = () => {
  const { id } = useParams();
  const [isLoading, setIsLoading] = useState(true);
  const [veterinary, setVeterinary] = useState(null);

  useEffect(() => {
    getVeterinary(id).then((res) => {
      const { data } = res;
      setVeterinary(data);
      setIsLoading(false);
    });
  }, []);

  return (
    <Layout
      navigation={[
        {
          text: veterinary?.id,
          link: "/veterinaries/" + veterinary?.id,
        },
      ]}
    >
      <h1 className="text-4xl my-5">Veterinary</h1>
      <section className="flex">
        {isLoading && (
          <div className="mx-auto">
            <Spinner size="xl" />
          </div>
        )}
        {!isLoading && (
          <div>
            <p>
              <strong>Name:</strong> {veterinary.name}
            </p>
            <p>
              <strong>First Name:</strong> {veterinary.first_name}
            </p>
            <p>
              <strong>Last Name:</strong> {veterinary.last_name}
            </p>
          </div>
        )}
      </section>
    </Layout>
  );
};

export default Show;
