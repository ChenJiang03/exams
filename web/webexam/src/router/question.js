import index from '@/views/admin/index'
import questionList from "@/views/admin/question/questionList";
import questionAdd from "@/views/admin/question/questionAdd";
import questionUpdate from "@/views/admin/question/questionUpdate";
const router={
    path: '/admin/question',
    component: index,
    children:[
        {
            path: 'list',
            component: questionList
        },
        {
            path: 'add',
            component: questionAdd
        },
        {
            path: 'update',
            component: questionUpdate
        }


    ]
}

export default router