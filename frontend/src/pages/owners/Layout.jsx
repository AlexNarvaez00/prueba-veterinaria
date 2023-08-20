import NavBreadcrumb from "../../components/NavBreadcrumb";

const Layout = ({ children, navigation = []}) => {
  return (
    <section className="container m-auto px-11 py-11">
      <NavBreadcrumb
        navigation={[
          {
            text: "owners",
            link: "/owners",
          },
          ...navigation,
        ]}
      />
      {children}
    </section>
  );
};

export default Layout;
