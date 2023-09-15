import index from "@/views/student/index"
import StudentRegister from "@/views/student/register";

const routes=
    {
        path: '/student',
        name:'index',
        component:index,
        children:[
            {
                path: 'register',
                name: 'studentRegister',
                component:StudentRegister
            }
        ]

    }


export default routes