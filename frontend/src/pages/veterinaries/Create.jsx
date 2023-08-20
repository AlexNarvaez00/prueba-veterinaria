import { Button, Label, TextInput } from "flowbite-react";
import Layout from "./Layout";
import { useId, useState } from "react";
import { createNewVeterinary } from "../../services/veterinaryService";

const Create = () => {
  const nameId = useId();
  const firstNameId = useId();
  const lastNameId = useId();
  const licenseId = useId();

  const [errors, setErrors] = useState(null);

  const handleSubmit = (event) => {
    event.preventDefault();
    const form = event.target;
    const formData = new FormData(form);
    const formJson = Object.fromEntries(formData.entries());
    createNewVeterinary(formJson)
      .then((res) => {
        const { data } = res;
      })
      .catch((error) => {
        const { data } = error.response;
        setErrors(data.errors);
      });
  };

  const getError = (field) => {
    if (errors.length == 0) {
      return "";
    }
    return errors.find((item) => {
      return item.source.includes(field);
    }).detail;
  };

  return (
    <Layout
      navigation={[
        {
          text: "create",
          link: "/veterinaries/create",
        },
      ]}
    >
      <h1 className="text-4xl my-5">Veterinary Form</h1>
      <form
        method="POST"
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
            helperText={
              errors ? (
                <>
                  <span>{getError("name")}</span>
                </>
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
          <TextInput id={firstNameId} type="text" name="first_name" />
        </div>
        <div>
          <div className="mb-2 block">
            <Label htmlFor={lastNameId}>Last Name</Label>
          </div>
          <TextInput id={lastNameId} type="text" name="last_name" />
        </div>
        <div>
          <div className="mb-2 block">
            <Label htmlFor={licenseId}>License</Label>
          </div>
          <TextInput id={licenseId} type="text" name="license" />
        </div>
        <Button type="submit">Submit</Button>
      </form>
    </Layout>
  );
};
export default Create;
