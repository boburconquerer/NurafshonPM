package com.example.nurafshonpm.Activities.activities.activity.profile.TMfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nurafshonpm.Activities.activities.adapters.GoalAdapter
import com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal.AppDatabase
import com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal.GoalData
import com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal.PlanData
import com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal.PlanDatabase
import com.example.nurafshonpm.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.snackbar.Snackbar


class DailyFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var goalAdapter: GoalAdapter
    private lateinit var goalList: ArrayList<GoalData>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_daily, container, false)
        initViews(view)
        return view

    }

    private fun initViews(view: View) {
        goalList = ArrayList()
        recyclerView = view.findViewById(R.id.recyclePlan_id)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        goalAdapter = GoalAdapter(goalList, this)
        recyclerView.adapter = goalAdapter


        fetchData()
        saveData(view)

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                // this method is called
                // when the item is moved.
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                // this method is called when we swipe our item to right direction.
                // on below line we are getting the item at a particular position.
                val deletedGoal: GoalData =
                    goalList[viewHolder.adapterPosition]

                // below line is to get the position
                // of the item at that position.
                val position = viewHolder.adapterPosition

                // this method is called when item is swiped.
                // below line is to remove item from our array list.
                goalList.removeAt(viewHolder.adapterPosition)
                val goalData = GoalData()
                goalData.id?.let { it1 ->
                    AppDatabase.getInstance(requireContext())?.goalDao()?.delete(
                        it1
                    )
                }


                // below line is to notify our item is removed from adapter.
                goalAdapter.notifyItemRemoved(viewHolder.adapterPosition)

                // below line is to display our snackbar with action.
                Snackbar.make(
                    recyclerView,
                    "Deleted " + deletedGoal.goalNames,
                    Snackbar.LENGTH_LONG
                )
                    .setAction(
                        "Undo",
                        View.OnClickListener {
                            // adding on click listener to our action of snack bar.
                            // below line is to add our item to array list with a position.
                            goalList.add(position, deletedGoal)

                            // below line is to notify item is
                            // added to our adapter class.
                            goalAdapter.notifyItemInserted(position)
                        }).show()
            }
            // at last we are adding this
            // to our recycler view.
        }).attachToRecyclerView(recyclerView)

        val textNewPlan = view.findViewById<LinearLayout>(R.id.newPlanLinear_id)
        textNewPlan.setOnClickListener {
            showBottomSheet()
        }
    }

    private fun showBottomSheet() {
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(R.layout.bottom_daily_plan_sheet)
        val buttonSubmit = bottomSheetDialog.findViewById<AppCompatButton>(R.id.createPlanButton_id)
        buttonSubmit?.setOnClickListener {
            bottomSheetDialog.dismiss()
            val titleEditTExt: EditText? = bottomSheetDialog.findViewById(R.id.yourPlan_id)
            val descEditText: EditText? = bottomSheetDialog.findViewById(R.id.planDescription_id)
            val textOfTitle = titleEditTExt?.text.toString().trim()
            val textOfDesc = descEditText?.text.toString().trim()
            val planData = PlanData(textOfTitle, textOfDesc)
            PlanDatabase.getInstance(requireContext())?.planDao()?.insert(planData)
            Toast.makeText(requireContext(), "Plan is saved", Toast.LENGTH_LONG).show()
        }
        bottomSheetDialog.show()
    }

    private fun fetchData() {
        val data = AppDatabase.getInstance(requireContext())?.goalDao()?.getAll()
        for (i in 0 until data?.reversed()!!.size) {
            val goals = data[i]
            goalAdapter.addGoals(goals)
        }

    }

    private fun saveData(view: View) {
        val submitButton: AppCompatButton = view.findViewById(R.id.submitGoal_id)
        submitButton.setOnClickListener {
            val goalEditText: EditText = view.findViewById(R.id.goalField_id)
            val textOfGoal = goalEditText.text.toString().trim()
            val goalData = GoalData(textOfGoal)
            goalAdapter.addGoals(goalData)
            AppDatabase.getInstance(requireContext())?.goalDao()?.insert(goalData)
            Toast.makeText(requireContext(), "Saved", Toast.LENGTH_LONG).show()
        }
    }


}