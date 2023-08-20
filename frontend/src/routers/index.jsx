import { createBrowserRouter } from "react-router-dom";
import Index from "../pages/veterinaries/index";
import ShowVeterinary from "../pages/veterinaries/Show";
import EditVeterinary from "../pages/veterinaries/Edit";
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
    path: "/veterinaries/:id/edit",
    element: <EditVeterinary />,
  },
  {
    path: "/owners",
    element: <IndexOwners />,
  },
]);

export default router;
