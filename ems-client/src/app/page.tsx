import { NewEmployeeModel } from "@/components/NewEmployeeModel";
import { TableDemo } from "@/components/Table";

export default function Home(){
  return (
    <div className="flex flex-col gap-10 items-center py-10 px-2 md:px-40">
      <TableDemo/>
      <NewEmployeeModel/>
    </div>
  )
}