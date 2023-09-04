import TeacherList from "@/views/admin/teacher/TeacherList";
import TeacherAdd from "@/views/admin/teacher/TeacherAdd";
import TeacherUpdate from "@/views/admin/teacher/TeacherUpdate";
import index from "@/views/admin/index"

const routes=
        {
            path: '/admin/teacher',
            component:index,
            children:[
                {
                    path: 'list',
                    name: 'teacherList',
                    component:TeacherList
                },
                {
                    path: 'update',
                    name: 'teacherUpdate',
                    component:TeacherUpdate
                },
                {
                    path: 'add',
                    name: 'teacherAdd',
                    component:TeacherAdd
                }
            ]
        }







export default routes