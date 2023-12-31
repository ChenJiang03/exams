import index from "@/views/admin/index"
import SubjectList from "@/views/admin/subject/SubjectList";
import SubjectAdd from "@/views/admin/subject/SubjectAdd";
import SubjectUpdate from "@/views/admin/subject/SubjectUpdate";


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
            },
            {
                path: 'update',
                name: 'subjectUpdate',
                component:SubjectUpdate
            }

        ]

    }


export default routes