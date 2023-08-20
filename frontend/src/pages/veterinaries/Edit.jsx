import { useParams } from "react-router-dom";
import Layout from "./Layout";
import { useEffect, useId, useState } from "react";
import { createNewVeterinary, getVeterinary, updateVeterinary } from "../../services/veterinaryService";
import { Button, Label, TextInput } from "flowbite-react";

const Edit = () => {
  const { id } = useParams();
  const [isLoading, setIsLoading] = useState(true);
  const [veterinary, setVeterinary] = useState(null);

  const nameId = useId();
  const firstNameId = useId();
  const lastNameId = useId();
  const licenseId = useId();

  const [errors, setErrors] = useState(null);

  const handleChange = (event) => {
    setVeterinary({ ...veterinary, [event.target.name]: event.target.value });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    const form = event.target;
    const formData = new FormData(form);
    const formJson = Object.fromEntries(formData.entries());
    updateVeterinary(id,formJson)
      .then((res) => {
        const { data } = res;
        setErrors(null);
        setVeterinary({});
      })
      .catch((error) => {
        const { data } = error.response;
        setErrors(data.errors);
      });
  };

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
        {
          text: "edit",
          link: "/veterinaries/" + veterinary?.id + "/edit",
        },
      ]}
    >
      <h1 className="text-4xl my-5">Veterinary Edit</h1>
      <form
        method="PUT"
        onSubmit={handleSubmit}
        className="flex max-w-md flex-col gap-4"
      >
        <div>
          <div className="mb-2 block">
            <Label htmlFor={nameId}>Name</Label>
          </div>
          <TextInput
            id={nameId}
            type="text"
            name="name"
            value={veterinary?.name}
            onChange={handleChange}
            color={errors ? (errors.name ? "failure" : "gray") : "gray"}
            helperText={
              errors?.name ? (
                <ErrorMessages messages={errors?.name ?? []} />
              ) : (
                <></>
              )
            }
          />
        </div>
        <div>
          <div className="mb-2 block">
            <Label htmlFor={firstNameId}>First Name</Label>
          </div>
          <TextInput
            id={firstNameId}
            type="text"
            name="first_name"
            value={veterinary?.first_name}
            onChange={handleChange}
            color={errors ? (errors.first_name ? "failure" : "gray") : "gray"}
            helperText={
              errors?.first_name ? (
                <ErrorMessages messages={errors?.first_name ?? []} />
              ) : (
                <></>
              )
            }
          />
        </div>
        <div>
          <div className="mb-2 block">
            <Label htmlFor={lastNameId}>Last Name</Label>
          </div>
          <TextInput
            id={lastNameId}
            type="text"
            name="last_name"
            value={veterinary?.last_name}
            onChange={handleChange}
            color={errors ? (errors.last_name ? "failure" : "gray") : "gray"}
            helperText={
              errors?.last_name ? (
                <ErrorMessages messages={errors?.last_name ?? []} />
              ) : (
                <></>
              )
            }
          />
        </div>
        <div>
          <div className="mb-2 block">
            <Label htmlFor={licenseId}>License</Label>
          </div>
          <TextInput
            id={licenseId}
            type="text"
            name="license"
            value={veterinary?.license}
            onChange={handleChange}
            color={errors ? (errors.license ? "failure" : "gray") : "gray"}
            helperText={
              errors?.license ? (
                <ErrorMessages messages={errors?.license ?? []} />
              ) : (
                <></>
              )
            }
          />
        </div>

        <Button type="submit">Update</Button>
      </form>
    </Layout>
  );
};
export default Edit;
