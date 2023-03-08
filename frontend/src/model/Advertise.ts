import { Apartment } from "./Apartment";
import { User } from "./User";

export type Advertise = {
  id: number;
  user: User;
  title: string;
  description: string;
  createdAt: Date;
  isActive: boolean;
  apartment: Apartment;
}