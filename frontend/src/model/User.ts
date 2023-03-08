import { Role } from "./Role";

export type User = {
  id: number;
  name: string;
  email: string;
  phone: string;
  password: string;
  role: Role;
}