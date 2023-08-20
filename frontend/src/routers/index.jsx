import { createBrowserRouter } from "react-router-dom";
import Index from "../pages/veterinaries/index";
import ShowVeterinary from "../pages/veterinaries/Show";
import CreateVeterinary from "../pages/veterinaries/Create";

import IndexOwners from "../pages/owners/index";

const router = createBrowserRouter([
  {
    path: "/veterinaries",
    element: <Index />,
  },
  {
    path: "/veterinaries/create",
    element: <CreateVeterinary />,
  },
  {
    path: "/veterinaries/:id",
    element: <ShowVeterinary />,
  },
  {
    path: "/owners",
    element: <IndexOwners />,
  },
]);

export default router;
