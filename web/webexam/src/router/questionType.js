import index from '@/views/admin/index'
import questionTypeList from "@/views/admin/questionType/questionTypeList";
import questionTypeAdd from "@/views/admin/questionType/questionTypeAdd";
import questionTypeUpdate from "@/views/admin/questionType/questionTypeUpdate";

const router={
    path: '/admin/questionType',
    component: index,
    children:[
        {
            path: 'list',
            component: questionTypeList
        },
        {
            path: 'add',
            component: questionTypeAdd
        },
        {
            path: 'update',
            component: questionTypeUpdate
        }
    ]
}

export default router