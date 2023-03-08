import { Building } from "./Building";
import { StatusApartment } from "./StatusApartment";
import { User } from "./User";

export type Apartment = {
  id: number;
  user: User;
  bedroom: string;
  bathroom: string;
  garage: string;
  floor: string;
  dimension: string;
  building: Building;
  statusApartment: StatusApartment;
  rentAmount: number;
  imageUrl: string;
};