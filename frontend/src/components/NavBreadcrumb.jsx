import { Breadcrumb } from "flowbite-react";

const NavBreadcrumb = ({ navigation }) => {
  return (
    <Breadcrumb>
      <Breadcrumb.Item href="/">Home</Breadcrumb.Item>
      {navigation?.map((nav, index) => {
        return <Breadcrumb.Item href={nav.link} key={index} >{nav.text}</Breadcrumb.Item>;
      })}
    </Breadcrumb>
  );
};
export default NavBreadcrumb;
