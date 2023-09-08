import index from "@/views/admin/index"
import SubjectList from "@/views/subject/SubjectList";
import SubjectAdd from "@/views/subject/SubjectAdd";

const routes=
    {
        path: '/subject',
        name:'index',
        component:index,
        children:[
            {
                path: 'list',
                name: 'subjectList',
                component:SubjectList
            },
            {
                path: 'add',
                name: 'subjectAdd',
                component:SubjectAdd
            }

        ]

    }


export default routes