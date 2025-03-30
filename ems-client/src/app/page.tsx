import { NewEmployeeModel } from "@/components/NewEmployeeModel";
import { TableDemo } from "@/components/Table";
import { Button } from "@/components/ui/button";

export default function Home(){
  return (
    <div className="flex flex-col gap-10 items-center py-10 px-40">
      <TableDemo/>
      <NewEmployeeModel/>
    </div>
  )
}